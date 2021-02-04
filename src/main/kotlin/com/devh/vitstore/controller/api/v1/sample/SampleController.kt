package com.devh.vitstore.controller.api.v1.sample

import com.devh.vitstore.common.annotation.BearerHeaderToken
import com.devh.vitstore.common.dto.ResultDataRes
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.NoHandlerFoundException
import java.io.Serializable
import java.time.LocalDateTime
import javax.servlet.http.HttpServletRequest

// TODO: huorlk-0450 This controller will remove later

@RestController
@RequestMapping("/api/v1/sample")
class SampleController {
    @GetMapping("/health")
    @BearerHeaderToken
    fun health(): ResponseEntity<ResultDataRes<Health>> =
        ResponseEntity.ok(ResultDataRes.Success(Health("Alive at ${LocalDateTime.now()}")))

    class Health(
        var status: String
    ) : Serializable

    @GetMapping("/testError")
    fun testError(request: HttpServletRequest): ResponseEntity<Any> {
        val errors = arrayListOf<Exception>(
            HttpMessageNotReadableException("Something went wrong with your request."),
            NoHandlerFoundException("HTTP", "/testError", HttpHeaders.EMPTY)
        )
        throw errors.random()
    }
}
