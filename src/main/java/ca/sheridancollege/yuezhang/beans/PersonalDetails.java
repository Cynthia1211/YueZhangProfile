package ca.sheridancollege.yuezhang.beans;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PersonalDetails {
	
	@Id
    private Long id = 1L;
	
	@NotBlank(message = "name not entered")
	@Size(min = 2, max = 50, message = "name length 2-50")
	private String name;
	@NotBlank(message = "phone not entered")
	@Pattern(regexp = "^\\d{10}$", message = "invalid phone number")
	private String phone;
	@NotBlank(message = "address not entered")
	private String address;
	@NotBlank(message = "email not entered")
	@Email(message = "invalid email")
	private String email;
	
	
}
