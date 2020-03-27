package network.piction.server_config

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.config.server.EnableConfigServer

@SpringBootApplication
@EnableConfigServer
@EnableEncryptableProperties
class PictionServerConfigApplication

fun main(args: Array<String>) {
    runApplication<PictionServerConfigApplication>(*args)
}
