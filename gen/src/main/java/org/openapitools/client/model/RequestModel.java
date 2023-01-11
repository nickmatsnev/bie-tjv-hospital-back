/*
 * Documentation
 * Documentation for backend by swagger
 *
 * The version of the OpenAPI document: 1.0.0
 * Contact: matsnnik@fit.cvut.cz
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * RequestModel
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-01-11T18:54:01.383901500+01:00[Europe/Prague]")
public class RequestModel {
  public static final String SERIALIZED_NAME_PATIENT_ID = "patientId";
  @SerializedName(SERIALIZED_NAME_PATIENT_ID)
  private Integer patientId;

  public static final String SERIALIZED_NAME_DOCTOR_ID = "doctorId";
  @SerializedName(SERIALIZED_NAME_DOCTOR_ID)
  private Integer doctorId;

  public static final String SERIALIZED_NAME_START_TIME = "startTime";
  @SerializedName(SERIALIZED_NAME_START_TIME)
  private String startTime;

  public static final String SERIALIZED_NAME_END_TIME = "endTime";
  @SerializedName(SERIALIZED_NAME_END_TIME)
  private String endTime;

  public static final String SERIALIZED_NAME_SESSION_NAME = "sessionName";
  @SerializedName(SERIALIZED_NAME_SESSION_NAME)
  private String sessionName;


  public RequestModel patientId(Integer patientId) {
    
    this.patientId = patientId;
    return this;
  }

   /**
   * Get patientId
   * @return patientId
  **/
  @ApiModelProperty(required = true, value = "")

  public Integer getPatientId() {
    return patientId;
  }


  public void setPatientId(Integer patientId) {
    this.patientId = patientId;
  }


  public RequestModel doctorId(Integer doctorId) {
    
    this.doctorId = doctorId;
    return this;
  }

   /**
   * Get doctorId
   * @return doctorId
  **/
  @ApiModelProperty(required = true, value = "")

  public Integer getDoctorId() {
    return doctorId;
  }


  public void setDoctorId(Integer doctorId) {
    this.doctorId = doctorId;
  }


  public RequestModel startTime(String startTime) {
    
    this.startTime = startTime;
    return this;
  }

   /**
   * Get startTime
   * @return startTime
  **/
  @ApiModelProperty(required = true, value = "")

  public String getStartTime() {
    return startTime;
  }


  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }


  public RequestModel endTime(String endTime) {
    
    this.endTime = endTime;
    return this;
  }

   /**
   * Get endTime
   * @return endTime
  **/
  @ApiModelProperty(required = true, value = "")

  public String getEndTime() {
    return endTime;
  }


  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }


  public RequestModel sessionName(String sessionName) {
    
    this.sessionName = sessionName;
    return this;
  }

   /**
   * Get sessionName
   * @return sessionName
  **/
  @ApiModelProperty(required = true, value = "")

  public String getSessionName() {
    return sessionName;
  }


  public void setSessionName(String sessionName) {
    this.sessionName = sessionName;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RequestModel requestModel = (RequestModel) o;
    return Objects.equals(this.patientId, requestModel.patientId) &&
        Objects.equals(this.doctorId, requestModel.doctorId) &&
        Objects.equals(this.startTime, requestModel.startTime) &&
        Objects.equals(this.endTime, requestModel.endTime) &&
        Objects.equals(this.sessionName, requestModel.sessionName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(patientId, doctorId, startTime, endTime, sessionName);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RequestModel {\n");
    sb.append("    patientId: ").append(toIndentedString(patientId)).append("\n");
    sb.append("    doctorId: ").append(toIndentedString(doctorId)).append("\n");
    sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
    sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
    sb.append("    sessionName: ").append(toIndentedString(sessionName)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
