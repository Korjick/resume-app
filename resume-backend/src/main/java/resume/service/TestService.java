package resume.service;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import resume.domain.Test;
import resume.dto.TestDto;
import resume.repository.TestRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestService {
    private final TestRepository testRepository;

    @Transactional(readOnly = true)
    public List<Test> findAll() {
        return testRepository.findAll();
    }

    public Test create(Test test) {
        return testRepository.save(test);
    }
}
