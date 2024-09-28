package service.business;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.assertArg;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.cpena.contactos.back.constants.ErrorMessageEnum;
import com.cpena.contactos.back.domain.entities.Profile;
import com.cpena.contactos.back.domain.entities.User;
import com.cpena.contactos.back.domain.repositories.UserRepository;
import com.cpena.contactos.back.services.business.UserServiceImpl;
import com.cpena.contactos.back.services.dtos.users.UserCreateDto;
import com.cpena.contactos.back.services.dtos.users.UserDto;
import com.cpena.contactos.back.services.exceptions.BusinessException;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
		
	@Mock
	private UserRepository userRepository;
	
	@InjectMocks
	private UserServiceImpl userService;
	
	@BeforeEach
	 void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	
	@Test
	void testGetAllUsers() {
//		Given 
		User user1 = new User();		
		user1.setId(1L);
		user1.setCreatedAt(new Date());
		user1.setName("Cristian");
		user1.setLastname("Pena Mesina");
		user1.setEmail("cpena@gmail.com");
		user1.setIsActive(true);
		user1.setPassword("ABc1");
		user1.setProfile(new Profile());
		
		User user2 = new User();		
		user2.setId(2L);
		user2.setCreatedAt(new Date());
		user2.setName("Fernando");
		user2.setLastname("Guitierrez Merluza");
		user2.setEmail("fgutimer@gmail.com");
		user2.setIsActive(true);
		user2.setPassword("abc124");
		user2.setProfile(new Profile());
		
//		When the service calls userRepository.findAll(), then it should return a List of Users.		
		Mockito.when(userRepository.findAll()).thenReturn(List.of(user1, user2));
		
		List<UserDto> users = userService.getAllUsers();
		
//		Then		
		assertEquals("cpena@gmail.com", users.get(0).getEmail());
		assertEquals(1L, users.get(0).getId());
		assertEquals("Cristian", users.get(0).getName());
		assertTrue(users.get(0).getIsActive());
		assertEquals("fgutimer@gmail.com", users.get(1).getEmail());
		assertEquals(2L, users.get(1).getId());
		assertEquals("Fernando", users.get(1).getName());
		assertTrue(users.get(1).getIsActive());
	}
	
	@Test
	void testGetAllUsersNotFound() {
//		Given
//		When		  
		BusinessException exception = assertThrows(BusinessException.class, () -> this.userService.getAllUsers());
//		then
		assertEquals(ErrorMessageEnum.RESOURCE_REQUEST_NOT_FOUND.getCode(), exception.getError().getErrorCode());
		assertEquals(ErrorMessageEnum.RESOURCE_REQUEST_NOT_FOUND.getMessage(),exception.getError().getErrorMessage());		
		
	}
	
	@Test
	void testDeleteUser() {
//		Given 
		final User user1 = new User();		
		user1.setId(1L);
		user1.setCreatedAt(new Date());
		user1.setName("Cristian");
		user1.setLastname("Pena Mesina");
		
		Optional<User> optionalUser = Optional.of(user1);
		Mockito.when(userRepository.findById(1L)).thenReturn(optionalUser);
		
//		when
		userService.deleteUser(user1.getId());
		
//		then
		Mockito.verify(userRepository, times(1)).delete(user1);
//		assertThat(userRepository.findById(1L).get()).isNull();
		
	}
	
	@Test
	void testDeleteUserNotFoundException() {
//		Given
//		When		  
		BusinessException exception = assertThrows(BusinessException.class, () -> this.userService.deleteUser(1L));
//		then
		assertEquals(ErrorMessageEnum.USER_NOT_FOUND.getCode(), exception.getError().getErrorCode());
		assertEquals(ErrorMessageEnum.USER_NOT_FOUND.getMessage(),exception.getError().getErrorMessage());	
	}
	
	@Test
	void testCreateUser() {
//		Given
		User newUser = new User();
//		newUser.setId(1L);
		newUser.setName("Francisco");
		newUser.setLastname("Fran");
		newUser.setEmail("ffran@gmail.com");
		newUser.setPassword("ABC12345");

		UserCreateDto userCreateDto = new UserCreateDto();
		userCreateDto.setName("Francisco");
		userCreateDto.setLastname("Fran");
		userCreateDto.setEmail("ffran@gmail.com");
		userCreateDto.setPassword("ABC12345");
		
		
//		when
		Mockito.when(userRepository
				.findByNameAndLastnameIgnoreCaseAllIgnoreCase(userCreateDto.getName(), userCreateDto.getLastname())).thenReturn(List.of());
		Mockito.when(userRepository.findByEmailAllIgnoreCase(userCreateDto.getEmail())).thenReturn(List.of());
		Mockito.when(userRepository.save(any(User.class))).thenReturn(newUser);
		
		UserDto userSavedDto = userService.createUser(userCreateDto);
		
//		then		
		Mockito.verify(userRepository, times(1)).save(any(User.class));
		assertThat(userSavedDto).isNotNull();
		
	}
	
	@Test
	void testGetUserByEmail() {
		User user = new User();
		user.setId(1L);
		user.setEmail("cpena@gmail.com");
		user.setCreatedAt(new Date());
		user.setName("Cristian");
		user.setLastname("Peña");
		
//		Given
		String userEmail = "cpena@gmail.com";
		
//		when
		Mockito.when(userRepository.findByEmailAllIgnoreCase(userEmail)).thenReturn(List.of(user));
		UserDto userFoundDto = userService.getUserByEmail(userEmail);
//		then		
		assertEquals(userFoundDto.getEmail(), userEmail);
		assertEquals(userFoundDto.getId(), user.getId());
		assertEquals(userFoundDto.getName(), user.getName());
		assertEquals(userFoundDto.getCreatedAt(), user.getCreatedAt());
	}
	
	@Test
	void testGetUserByEmailNotFoundException() {
//		Given
//		When
		BusinessException exception = assertThrows(BusinessException.class, ()->{
			userService.getUserByEmail("email@gmail.com");			
		});
//		Then
		assertEquals(ErrorMessageEnum.USER_NOT_FOUND.getCode(), exception.getError().getErrorCode() );
		assertEquals(ErrorMessageEnum.USER_NOT_FOUND.getMessage(), exception.getError().getErrorMessage());
	}
	
	@Test
	void testGetUserByEmailEmailNotUnique() {
//		Given
		User user1 = new User();
		user1.setId(1L);
		user1.setName("Cristian");
		user1.setLastname("Pena");
		user1.setEmail("cpena@gmail.com");		
		
		User user2 = new User();
		user2.setId(2L);
		user2.setName("Francisco");
		user2.setLastname("Gajardo");
		user2.setEmail("cpena@gmail.com");		
		
//		When
		Mockito.when(userRepository.findByEmailAllIgnoreCase("cpena@gmail.com")).thenReturn(List.of(user1, user2));
		BusinessException exception = assertThrows(BusinessException.class, ()->{
			userService.getUserByEmail("cpena@gmail.com");
		});
//		Then
		assertEquals(ErrorMessageEnum.USER_EMAIL_MUST_BE_UNIQUE.getCode(), exception.getError().getErrorCode());
		assertEquals(ErrorMessageEnum.USER_EMAIL_MUST_BE_UNIQUE.getMessage(), exception.getError().getErrorMessage());
	}
	
	
//	@Test
//	public void testGetAllUsers() {
////		Given
//		User user1 = new User();
//		user1.setId(1L);
//		user1.setName("Cristian");
//		user1.setLastname("Pena");
//		user1.setEmail("cpena@gmail.com");		
//		
//		User user2 = new User();
//		user2.setId(2L);
//		user2.setName("Francisco");
//		user2.setLastname("Gajardo");
//		user2.setEmail("fgajardo@gmail.com");
//		
////		when
//		Mockito.when(userRepository.findAll()).thenReturn(List.of(user1, user2));
//		
////		Then
//		List<UserDto> userDtos = userService.getAllUsers();
//		
//		assertFalse(userDtos.isEmpty());		
//		assertEquals(2, userDtos.size());
//		assertEquals("Cristian", userDtos.get(0).getName());
//		assertEquals("Pena", userDtos.get(0).getLastname());
//		assertEquals("cpena@gmail.com", userDtos.get(0).getEmail());
//		assertEquals("Francisco", userDtos.get(1).getName());
//		assertEquals("Gajardo", userDtos.get(1).getLastname());
//		assertEquals("fgajardo@gmail.com", userDtos.get(1).getEmail());
//		
//		
//		
//		
//	}
	
	@Test
	public void testCreateUserWhenUserNameAndLastnameAlreadyExists() {
		
	}
	
	@Test
	public void testCreasteUserWhenUserEmailAlreadyExist() {
		
	}

}
