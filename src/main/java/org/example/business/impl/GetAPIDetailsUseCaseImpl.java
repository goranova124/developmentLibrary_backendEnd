package org.example.business.impl;

import lombok.AllArgsConstructor;
import org.example.business.GetAPIDetailsUseCase;
import org.example.domain.API;
import org.example.domain.GetAPIDetailsResponse;
import org.example.persistence.APIRepository;
import org.example.persistence.entity.APIEntity;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GetAPIDetailsUseCaseImpl implements GetAPIDetailsUseCase {
    private final APIRepository apiRepository;

    @Override
    public GetAPIDetailsResponse getAPIDetails(String name)   {
        Optional<APIEntity> entity = apiRepository.getApiDetails(name);
        Optional<API> api = entity.map(APIConverter::convert);

        return GetAPIDetailsResponse.builder().api(api).build();
    }
}
