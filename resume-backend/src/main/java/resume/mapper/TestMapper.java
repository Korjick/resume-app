package resume.mapper;

import org.mapstruct.Mapper;
import resume.domain.Test;
import resume.dto.TestDto;

@Mapper(componentModel = "spring")
public interface TestMapper {
    TestDto toDto(Test source);
    Test toEntity(TestDto testDto);
}
