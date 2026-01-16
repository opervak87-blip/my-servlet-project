package ca.http.myservlet.bean.dto.factory;

import ca.http.myservlet.bean.Address;
import ca.http.myservlet.bean.City;
import ca.http.myservlet.bean.Province;
import ca.http.myservlet.bean.User;
import ca.http.myservlet.bean.UserDetail;
import ca.http.myservlet.bean.dto.RegistrationRequestDTO;
import ca.http.myservlet.util.InputUtils;
import ca.http.myservlet.util.PasswordUtils;

public class FactoryBean {
	
	public static User toUser(RegistrationRequestDTO dto) {
		
		Province province = new Province.Builder()
				.id(InputUtils.stringToInt(dto.getProvinceId()))
				.build();
		
		City city = new City.Builder()
				.id(InputUtils.stringToInt(dto.getCityId()))
				.province(province)
				.build();
				
		
		Address address = new Address.Builder()
				.streetNumber(dto.getStreetNumber())
				.streetName(dto.getStreetName())
				.apartmentNumber(dto.getApartmentNumber())
				.postalCode(dto.getPostalCode())
				.city(city)
				.builder();
		
		UserDetail userDetail = new UserDetail.Builder()
				.firstName(dto.getFirstName())
				.lastName(dto.getLastName())
				.middleName(dto.getMiddleName())
				.phone(dto.getPhone())
				.address(address)
				.build();

		User user = new User.Builder()
				.email(dto.getEmail())
				.fullName(dto.getFirstName() + " " + dto.getLastName())
				.isActive(true)
				.login(dto.getLogin())
				.password(PasswordUtils.hashPassword(dto.getPassword()))
				.roles(dto.getRoles())
				.userDetail(userDetail)
				.build();
		
		return user;
	}

}
