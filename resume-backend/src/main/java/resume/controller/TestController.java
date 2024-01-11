package resume.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import resume.domain.Test;
import resume.dto.TestDto;
import resume.mapper.TestMapper;
import resume.service.TestService;

import java.util.List;
import java.util.stream.Collectors;

@RestController("/api/v1/test")
@RequiredArgsConstructor
@Slf4j
public class TestController {
    private final TestService testService;
    private final TestMapper testMapper;

    @GetMapping
    public ResponseEntity<List<TestDto>> findAll(){
        log.info("findAll");
        return ResponseEntity.ok(testService.findAll().stream().map(testMapper::toDto).toList());
    }

    @PostMapping
    public ResponseEntity<TestDto> create(@RequestBody @Valid TestDto testDto) {
        Test test = testService.create(testMapper.toEntity(testDto));
        return ResponseEntity.ok(testMapper.toDto(test));
    }
}
