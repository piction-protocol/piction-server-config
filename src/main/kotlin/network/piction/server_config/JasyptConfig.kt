package network.piction.server_config

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.DependsOn

@DependsOn("SecretsProperties")
@Configuration
class JasyptConfig {

    @Bean("encryptorBean")
    fun stringEncryptor() = PooledPBEStringEncryptor().apply {
        val config = SimpleStringPBEConfig()
        config.password = SecretsProperties.jasyptPassword
        config.algorithm = "PBEWithMD5AndDES"
        config.setKeyObtentionIterations("1000")
        config.setPoolSize("1")
        config.providerName = "SunJCE"
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator")
        config.stringOutputType = "base64"
        this.setConfig(config)
    }
}