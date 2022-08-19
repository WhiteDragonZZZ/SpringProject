package com.example.finalspring.AOP;


import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.logging.Logger;

@Configuration
@ComponentScan("com.example.finalspring")
@EnableAspectJAutoProxy
public class ConfigAop {

}
