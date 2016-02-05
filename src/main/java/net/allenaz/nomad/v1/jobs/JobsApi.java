package net.allenaz.nomad.v1.jobs;

import feign.Param;
import feign.RequestLine;
import net.allenaz.nomad.v1.jobs.models.Job;

import java.util.List;

public interface JobsApi {
    String jobsUrl = "/v1/jobs";

    @RequestLine("GET " + jobsUrl) List<Job> getJobs();

    @RequestLine("GET " + jobsUrl + "?region={region}") List<Job> getJobsForRegion(@Param("region") String region);
}
