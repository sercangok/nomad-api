package io.github.zanella.nomad.v1.jobs.models;

import com.fasterxml.jackson.annotation.JsonRootName;

import io.github.zanella.nomad.v1.common.models.Job;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@JsonRootName("Job")
public class JobSpec extends Job {
}
