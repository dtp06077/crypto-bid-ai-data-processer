package com.example.cryptodatareceiver.rest.service.implement;

import com.example.cryptodatareceiver.constant.Constant;
import com.example.cryptodatareceiver.dto.request.object.SaveTickerRequestDto;
import com.example.cryptodatareceiver.dto.response.ResponseDto;
import com.example.cryptodatareceiver.dto.response.SaveTickerResponseDto;
import com.example.cryptodatareceiver.rest.service.TickerService;
import com.example.cryptodatareceiver.transfer.JsonToRequestTransfer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class TickerServiceImpl implements TickerService {

    private final RestTemplate restTemplate;
    private final JsonToRequestTransfer jsonToRequestTransfer;

    @Override
    public ResponseEntity<? super SaveTickerResponseDto> saveTickerRequest(String textMessage) {

        String url = Constant.REST_LOCAL_URL+"/ticker";
        SaveTickerRequestDto requestDto = jsonToRequestTransfer.transfer(textMessage);

        return restTemplate.postForEntity(url, requestDto, ResponseDto.class);
    }
}
