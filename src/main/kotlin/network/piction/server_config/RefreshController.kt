package network.piction.server_config

import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.util.MultiValueMap
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import javax.servlet.http.HttpServletRequest

@RestController
@RequestMapping
class RefreshController {

    @PostMapping("/refresh")
    fun refresh(request: HttpServletRequest) = RestTemplate().postForEntity(
        request.requestURL.toString().replace(request.requestURI, "/actuator/bus-refresh"),
        HttpEntity<MultiValueMap<String, String>?>(null, HttpHeaders().apply {
            this.add(HttpHeaders.CONTENT_TYPE, "application/json")
        }),
        String::class.java
    )
}