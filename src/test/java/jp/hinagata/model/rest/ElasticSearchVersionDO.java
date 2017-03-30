package jp.hinagata.model.rest;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ElasticSearchVersionDO {

    @JsonCreator
    public ElasticSearchVersionDO(@JsonProperty("number") String versionNumber,
                                  @JsonProperty("build_date") String buildDate,
                                  @JsonProperty("build_hash") String buildHash,
                                  @JsonProperty("build_snapshot") boolean buildSnapshot,
                                  @JsonProperty("lucene_version") String luceneVersion) {
        this.versionNumber = versionNumber;
        this.buildDate = buildDate;
        this.buildHash = buildHash;
        this.buildSnapshot = buildSnapshot;
        this.luceneVersion = luceneVersion;
    }

    private String versionNumber;
    private String buildDate;
    private String buildHash;
    private boolean buildSnapshot;
    private String luceneVersion;
}
