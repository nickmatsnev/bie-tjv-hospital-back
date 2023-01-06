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
import org.threeten.bp.OffsetDateTime;

/**
 * SessionActualDTO
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-01-06T20:44:24.716928700+01:00[Europe/Prague]")
public class SessionActualDTO {
  public static final String SERIALIZED_NAME_PLANNED_START = "plannedStart";
  @SerializedName(SERIALIZED_NAME_PLANNED_START)
  private OffsetDateTime plannedStart;

  public static final String SERIALIZED_NAME_PLANNED_END = "plannedEnd";
  @SerializedName(SERIALIZED_NAME_PLANNED_END)
  private OffsetDateTime plannedEnd;

  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_DOCTOR = "doctor";
  @SerializedName(SERIALIZED_NAME_DOCTOR)
  private Long doctor;

  public static final String SERIALIZED_NAME_PATIENT = "patient";
  @SerializedName(SERIALIZED_NAME_PATIENT)
  private String patient;


  public SessionActualDTO plannedStart(OffsetDateTime plannedStart) {
    
    this.plannedStart = plannedStart;
    return this;
  }

   /**
   * Get plannedStart
   * @return plannedStart
  **/
  @ApiModelProperty(required = true, value = "")

  public OffsetDateTime getPlannedStart() {
    return plannedStart;
  }


  public void setPlannedStart(OffsetDateTime plannedStart) {
    this.plannedStart = plannedStart;
  }


  public SessionActualDTO plannedEnd(OffsetDateTime plannedEnd) {
    
    this.plannedEnd = plannedEnd;
    return this;
  }

   /**
   * Get plannedEnd
   * @return plannedEnd
  **/
  @ApiModelProperty(required = true, value = "")

  public OffsetDateTime getPlannedEnd() {
    return plannedEnd;
  }


  public void setPlannedEnd(OffsetDateTime plannedEnd) {
    this.plannedEnd = plannedEnd;
  }


  public SessionActualDTO name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(required = true, value = "")

  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public SessionActualDTO doctor(Long doctor) {
    
    this.doctor = doctor;
    return this;
  }

   /**
   * Get doctor
   * @return doctor
  **/
  @ApiModelProperty(required = true, value = "")

  public Long getDoctor() {
    return doctor;
  }


  public void setDoctor(Long doctor) {
    this.doctor = doctor;
  }


  public SessionActualDTO patient(String patient) {
    
    this.patient = patient;
    return this;
  }

   /**
   * Get patient
   * @return patient
  **/
  @ApiModelProperty(required = true, value = "")

  public String getPatient() {
    return patient;
  }


  public void setPatient(String patient) {
    this.patient = patient;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SessionActualDTO sessionActualDTO = (SessionActualDTO) o;
    return Objects.equals(this.plannedStart, sessionActualDTO.plannedStart) &&
        Objects.equals(this.plannedEnd, sessionActualDTO.plannedEnd) &&
        Objects.equals(this.name, sessionActualDTO.name) &&
        Objects.equals(this.doctor, sessionActualDTO.doctor) &&
        Objects.equals(this.patient, sessionActualDTO.patient);
  }

  @Override
  public int hashCode() {
    return Objects.hash(plannedStart, plannedEnd, name, doctor, patient);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SessionActualDTO {\n");
    sb.append("    plannedStart: ").append(toIndentedString(plannedStart)).append("\n");
    sb.append("    plannedEnd: ").append(toIndentedString(plannedEnd)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    doctor: ").append(toIndentedString(doctor)).append("\n");
    sb.append("    patient: ").append(toIndentedString(patient)).append("\n");
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

