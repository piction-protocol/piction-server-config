package network.piction.server_config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.PropertySource
import org.springframework.stereotype.Component

@Component("SecretsProperties")
@ConfigurationProperties
@PropertySource(value = ["classpath:/secrets.yml"], encoding = "UTF-8")
object SecretsProperties {
    lateinit var jasyptPassword: String
}