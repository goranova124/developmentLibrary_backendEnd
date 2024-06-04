package org.example.business.impl;

import lombok.AllArgsConstructor;
import org.example.business.GetAPIUseCase;
import org.example.domain.API;
import org.example.domain.GetAPISResponse;
import org.example.persistence.entity.APIEntity;
import org.example.persistence.APIRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GetAPISUseCaseImpl implements GetAPIUseCase {
    private final APIRepository apiRepository;

    @Override
    public GetAPISResponse getApiResponse() throws SQLException {
        List<APIEntity> resultSet = apiRepository.getAPIS();

        final GetAPISResponse response = GetAPISResponse.builder().build();
        List<API> results = resultSet.stream().map(APIConverter::convert).collect(Collectors.toList());
        response.setApiEntity(results);
        return response;
    }
}
