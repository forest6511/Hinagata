package jp.hinagata.model.rest;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ElasticSearchInfoDO {
    private String name;
    private String clusterName;
    private String clusterUuid;
    private ElasticSearchVersionDO version;
    private String tagLine;
    @JsonCreator
    public ElasticSearchInfoDO(
            @JsonProperty("name") String name,
            @JsonProperty("cluster_name") String clusterName,
            @JsonProperty("cluster_uuid") String clusterUuid,
            @JsonProperty("version") ElasticSearchVersionDO version,
            @JsonProperty("tagline") String tagLine
    ) {
        this.name = name;
        this.clusterName = clusterName;
        this.clusterUuid = clusterUuid;
        this.version = version;
        this.tagLine = tagLine;
    }

}
