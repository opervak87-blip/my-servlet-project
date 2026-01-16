package ca.http.myservlet.bean.dto.factory;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ca.http.myservlet.bean.dto.RegistrationRequestDTO;
import ca.http.myservlet.config.AppConstants;
import ca.http.myservlet.util.InputUtils;

public class FactoryDTO {
	
	public static RegistrationRequestDTO toRegistrationRequestDTO(HttpServletRequest request) {
      
		RegistrationRequestDTO dto = new RegistrationRequestDTO();

        dto.setEmail(InputUtils.trim(request.getParameter(AppConstants.EMAIL.get())));
        dto.setPassword(InputUtils.trim(request.getParameter(AppConstants.PASSWORD.get())));
        dto.setLogin(InputUtils.trim(request.getParameter(AppConstants.LOGIN_SMALL_LETTER.get())));
        dto.setFirstName(InputUtils.trim(request.getParameter(AppConstants.FIRST_NAME.get())));
        dto.setLastName(InputUtils.trim(request.getParameter(AppConstants.LAST_NAME.get())));
        dto.setMiddleName(InputUtils.trim(request.getParameter(AppConstants.MIDDLE_NAME.get())));
        dto.setStreetNumber(InputUtils.trim(request.getParameter(AppConstants.STREET_NUMBER.get())));
        dto.setStreetName(InputUtils.trim(request.getParameter(AppConstants.STREET_NAME.get())));
        dto.setApartmentNumber(InputUtils.trim(request.getParameter(AppConstants.APARTMENT_NUMBER.get())));
        dto.setProvinceId(InputUtils.trim(request.getParameter(AppConstants.PROVINCE_ID.get())));
        dto.setCityId(InputUtils.trim(request.getParameter(AppConstants.CITY_ID.get())));
        dto.setPostalCode(InputUtils.trim(request.getParameter(AppConstants.POSTAL_CODE.get())));
        dto.setPhone(InputUtils.trim(request.getParameter(AppConstants.PHONE.get())));
        dto.setRoles(List.of(AppConstants.ROLE_USER.get()));

        return dto;
    }

}
