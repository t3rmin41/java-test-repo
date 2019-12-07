package com.simple.service

import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class CommandService
@Autowired
constructor(
        private val objectMapper: ObjectMapper,
        private val kafkaTemplate: KafkaTemplate<String, String>
) {

    private val log = LoggerFactory.getLogger(this.javaClass)

    fun executeCommand(identifierId: String) {
        val sent = sendCommand(
                SampleCommand(
                        type = "SampleType",
                        identifierId = identifierId
                )
        )
        log.info("[$identifierId] sample command was send: $sent")
    }

    fun sendCommand(cmd: SampleCommand): Boolean {
        return this.kafkaTemplate.send("some-topic", objectMapper.writeValueAsString(cmd)).isDone
    }
}

data class SampleCommand(
        val type: String? = null,
        val identifierId: String? = null,
        val clean: Boolean? = false
)
