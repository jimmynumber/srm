package com.want.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicConfig {
	@Bean(name="queueMessageTop1")
	public Queue queueMessageTop1() {
		return new Queue("topic.a");
	}

	@Bean(name="queueMessageTop2")
	public Queue queueMessageTop2() {
		return new Queue("topic.b");
	}

	@Bean(name="topicExchangeTop")
	TopicExchange topicExchangeTop() {
		return new TopicExchange("topicExchange");
	}

	@Bean(name="bindingExchangeMessageTop1")
	Binding bindingExchangeMessageTop1(@Qualifier("queueMessageTop1") Queue queueMessageTop1, @Qualifier("topicExchangeTop")TopicExchange topicExchangeTop) {
		return BindingBuilder.bind(queueMessageTop1).to(topicExchangeTop).with("topic.a");
	}

	@Bean(name="bindingExchangeMessageTop2")
	Binding bindingExchangeMessageTop2(@Qualifier("queueMessageTop2")Queue queueMessageTop2, @Qualifier("topicExchangeTop")TopicExchange topicExchangeTop) {
		return BindingBuilder.bind(queueMessageTop2).to(topicExchangeTop).with("topic.#");
	}

}
