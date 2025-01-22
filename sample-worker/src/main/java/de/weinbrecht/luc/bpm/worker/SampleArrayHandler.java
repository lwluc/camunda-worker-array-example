package de.weinbrecht.luc.bpm.worker;

import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
@ExternalTaskSubscription("sampleArrayWorker")
class SampleArrayHandler implements ExternalTaskHandler {

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {
        ArrayList array = new ArrayList<>(List.of("1", "2"));
        externalTaskService.complete(externalTask, Map.of("sample_array", array));
    }
}
