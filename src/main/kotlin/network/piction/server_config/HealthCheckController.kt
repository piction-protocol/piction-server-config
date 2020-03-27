package network.piction.server_config

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest

@RestController
class HealthCheckController {

    @GetMapping("/health-check")
    fun healthCheck(request: HttpServletRequest) = "ok"
}