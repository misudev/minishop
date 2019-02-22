package my.example.minishop.service;

import lombok.RequiredArgsConstructor;
import my.example.minishop.domain.PhoneType;
import my.example.minishop.repository.PhoneTypeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhoneTypeService {
    private final PhoneTypeRepository phoneTypeRepository;

    @Transactional(readOnly = true)
    public List<PhoneType> getAll(){
        return phoneTypeRepository.findAll();
    }

    @Transactional(readOnly = true)
    public PhoneType getById(Long id) {return  phoneTypeRepository.getOne(id);}

}
