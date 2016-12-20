package io.github.zanella.nomad.v1.client.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(suppressConstructorProperties = true)
public class AllocationFile {

    @JsonProperty("Name") String name;

    @JsonProperty("IsDir") boolean isDir;

    @JsonProperty("Size") Long size;

    @JsonProperty("FileMode") String fileMode;

    @JsonProperty("ModTime") String modTime;
}
