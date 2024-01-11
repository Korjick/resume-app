package resume.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FieldValidationErrorDto {
    private String fieldName;
    private String errorMessage;
}
