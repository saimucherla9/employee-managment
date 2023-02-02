package org.sai.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.sai.entity.EmployeeInfo;
import org.sai.model.EmployeeDTO;
import org.sai.repo.EmployeeRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeService {


    private final EmployeeRepo employeeRepo;
    private final ModelMapper modelMapper;

    public EmployeeDTO saveEmployeeInfo(EmployeeDTO employeeDTO) {
        EmployeeInfo entityTobeCreated = modelMapper.map(employeeDTO, EmployeeInfo.class);
        EmployeeInfo entityCreated = employeeRepo.save(entityTobeCreated);
        EmployeeDTO response = modelMapper.map(entityCreated, EmployeeDTO.class);
        return response;
    }

    public List<EmployeeDTO> getAllData() {
        List<EmployeeInfo> allData = employeeRepo.findAll();
        List<EmployeeDTO> response = new ArrayList<>();
        for (EmployeeInfo employeeInfo : allData) {
            EmployeeDTO employeeDTO = modelMapper.map(employeeInfo, EmployeeDTO.class);
            response.add(employeeDTO);
        }
        return response;
        //return  allData.stream().map(obj -> modelMapper.map(obj, EmployeeDTO.class )).collect(Collectors.toList());
    }
}
