package com.capgeminitraining.week4.day6annotationsreflection.reflections.advancedlevel;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InjectionReflectionTest {
    @Test
    void testDependencyInjection() {

        DIContainer diContainer = new DIContainer();
        ServiceImpl serviceImpl = new ServiceImpl();
        diContainer.register(Service.class, serviceImpl);

        Client client = new Client();

        diContainer.injectDependencies(client);

        assertNotNull(client.service, "Dependency should be injected");
        assertSame(serviceImpl, client.service, "Injected instance should be the registered one");
    }

}