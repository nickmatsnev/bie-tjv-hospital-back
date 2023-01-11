# DefaultApi

All URIs are relative to *http://localhost:8085*

Method | HTTP request | Description
------------- | ------------- | -------------
[**accept**](DefaultApi.md#accept) | **GET** /requests/accept/{name}/{doctor}/{patient} | 
[**create**](DefaultApi.md#create) | **POST** /sessions/create | 
[**delete**](DefaultApi.md#delete) | **DELETE** /sessions/session/{oid} | 
[**doctorsDidDelete**](DefaultApi.md#doctorsDidDelete) | **DELETE** /doctors/{did} | Delete a doctor by ID
[**doctorsDidGet**](DefaultApi.md#doctorsDidGet) | **GET** /doctors/{did} | Get a doctor by ID
[**doctorsDidPut**](DefaultApi.md#doctorsDidPut) | **PUT** /doctors/{did} | Update a doctor by ID
[**doctorsLoginPost**](DefaultApi.md#doctorsLoginPost) | **POST** /doctors/login | Log in a doctor
[**doctorsRegisterPost**](DefaultApi.md#doctorsRegisterPost) | **POST** /doctors/register | Register a new doctor
[**get**](DefaultApi.md#get) | **GET** /sessions/session/{oid} | 
[**getByDoctorId**](DefaultApi.md#getByDoctorId) | **GET** /sessions/doctor/{id} | 
[**getByNameAndDoctor**](DefaultApi.md#getByNameAndDoctor) | **GET** /sessions/session/name/{doctor}/{name} | 
[**getByPatientId**](DefaultApi.md#getByPatientId) | **GET** /sessions/patient/{id} | 
[**patientsAllGet**](DefaultApi.md#patientsAllGet) | **GET** /patients/all | Get all patients
[**patientsEmailEmailGet**](DefaultApi.md#patientsEmailEmailGet) | **GET** /patients/email/{email} | Get a patient by email
[**patientsLoginPost**](DefaultApi.md#patientsLoginPost) | **POST** /patients/login | Log in a patient
[**patientsPidGet**](DefaultApi.md#patientsPidGet) | **GET** /patients/{pid} | Get a patient by ID
[**patientsRegisterPost**](DefaultApi.md#patientsRegisterPost) | **POST** /patients/register | Register a new patient
[**reject**](DefaultApi.md#reject) | **GET** /requests/reject/{name}/{doctor}/{patient} | 
[**requestsCreatePost**](DefaultApi.md#requestsCreatePost) | **POST** /requests/create | Create a new request
[**requestsIdGet**](DefaultApi.md#requestsIdGet) | **GET** /requests/{id} | Get request session by ID
[**requestsPendingDoctorIdGet**](DefaultApi.md#requestsPendingDoctorIdGet) | **GET** /requests/pending/doctor/{id} | Get pending request sessions objects by doctor ID
[**requestsPendingPatientIdGet**](DefaultApi.md#requestsPendingPatientIdGet) | **GET** /requests/pending/patient/{id} | Get pending request sessions objects by patient ID
[**requestsRejectedDoctorIdGet**](DefaultApi.md#requestsRejectedDoctorIdGet) | **GET** /requests/rejected/doctor/{id} | Get rejected request sessions objects by doctor ID
[**requestsRejectedPatientIdGet**](DefaultApi.md#requestsRejectedPatientIdGet) | **GET** /requests/rejected/patient/{id} | Get rejected request sessions objects by doctor ID
[**update**](DefaultApi.md#update) | **POST** /sessions/session/name/{doctor}/{name} | 


<a name="accept"></a>
# **accept**
> accept(name, doctor, patient)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8085");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String name = "name_example"; // String | 
    Integer doctor = 56; // Integer | 
    Integer patient = 56; // Integer | 
    try {
      apiInstance.accept(name, doctor, patient);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#accept");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **String**|  |
 **doctor** | **Integer**|  |
 **patient** | **Integer**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Success |  -  |
**404** | Not Found |  -  |

<a name="create"></a>
# **create**
> create()



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8085");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    try {
      apiInstance.create();
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#create");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Success |  -  |
**409** | Conflict |  -  |

<a name="delete"></a>
# **delete**
> delete(oid)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8085");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer oid = 56; // Integer | 
    try {
      apiInstance.delete(oid);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#delete");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **oid** | **Integer**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Success |  -  |
**404** | Not Found |  -  |
**409** | Conflict |  -  |

<a name="doctorsDidDelete"></a>
# **doctorsDidDelete**
> String doctorsDidDelete(did)

Delete a doctor by ID

Deletes the doctor with the specified ID. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8085");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer did = 56; // Integer | 
    try {
      String result = apiInstance.doctorsDidDelete(did);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#doctorsDidDelete");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **did** | **Integer**|  |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The doctor was deleted successfully |  -  |
**404** | The doctor with the specified ID was not found |  -  |

<a name="doctorsDidGet"></a>
# **doctorsDidGet**
> DoctorModel doctorsDidGet(did)

Get a doctor by ID

Returns the doctor with the specified ID. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8085");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer did = 56; // Integer | 
    try {
      DoctorModel result = apiInstance.doctorsDidGet(did);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#doctorsDidGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **did** | **Integer**|  |

### Return type

[**DoctorModel**](DoctorModel.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The requested doctor was returned successfully |  -  |
**404** | The doctor with the specified ID was not found |  -  |

<a name="doctorsDidPut"></a>
# **doctorsDidPut**
> String doctorsDidPut(did, doctor)

Update a doctor by ID

Updates the doctor with the specified ID. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8085");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer did = 56; // Integer | 
    DoctorModel doctor = new DoctorModel(); // DoctorModel | 
    try {
      String result = apiInstance.doctorsDidPut(did, doctor);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#doctorsDidPut");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **did** | **Integer**|  |
 **doctor** | [**DoctorModel**](DoctorModel.md)|  |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The doctor was updated successfully |  -  |
**409** | A conflict occurred while updating the doctor |  -  |

<a name="doctorsLoginPost"></a>
# **doctorsLoginPost**
> String doctorsLoginPost(doctor)

Log in a doctor

Logs in a doctor by verifying their ID and password. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8085");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    DoctorLoginDTO doctor = new DoctorLoginDTO(); // DoctorLoginDTO | 
    try {
      String result = apiInstance.doctorsLoginPost(doctor);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#doctorsLoginPost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **doctor** | **DoctorLoginDTO**|  |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The doctor was logged in successfully |  -  |
**401** | The ID and password combination is invalid |  -  |
**404** | The doctor with the specified ID was not found |  -  |

<a name="doctorsRegisterPost"></a>
# **doctorsRegisterPost**
> String doctorsRegisterPost(doctor)

Register a new doctor

Registers a new doctor in the system. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8085");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    DoctorModel doctor = new DoctorModel(); // DoctorModel | 
    try {
      String result = apiInstance.doctorsRegisterPost(doctor);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#doctorsRegisterPost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **doctor** | [**DoctorModel**](DoctorModel.md)|  |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The doctor was registered successfully |  -  |
**409** | A doctor with the same ID already exists |  -  |

<a name="get"></a>
# **get**
> get(oid)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8085");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer oid = 56; // Integer | 
    try {
      apiInstance.get(oid);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#get");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **oid** | **Integer**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** |  |  -  |
**404** | Not Found |  -  |

<a name="getByDoctorId"></a>
# **getByDoctorId**
> getByDoctorId(id)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8085");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer id = 56; // Integer | 
    try {
      apiInstance.getByDoctorId(id);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#getByDoctorId");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** |  |  -  |
**404** | Not Found |  -  |

<a name="getByNameAndDoctor"></a>
# **getByNameAndDoctor**
> getByNameAndDoctor(doctor, name)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8085");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer doctor = 56; // Integer | 
    String name = "name_example"; // String | 
    try {
      apiInstance.getByNameAndDoctor(doctor, name);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#getByNameAndDoctor");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **doctor** | **Integer**|  |
 **name** | **String**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** |  |  -  |
**404** | Not Found |  -  |

<a name="getByPatientId"></a>
# **getByPatientId**
> getByPatientId(id)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8085");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer id = 56; // Integer | 
    try {
      apiInstance.getByPatientId(id);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#getByPatientId");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** |  |  -  |
**404** | Not Found |  -  |

<a name="patientsAllGet"></a>
# **patientsAllGet**
> List&lt;PatientDTO&gt; patientsAllGet()

Get all patients

Returns a list of all patients in the system. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8085");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    try {
      List<PatientDTO> result = apiInstance.patientsAllGet();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#patientsAllGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;PatientDTO&gt;**](PatientDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The list of patients was returned successfully |  -  |

<a name="patientsEmailEmailGet"></a>
# **patientsEmailEmailGet**
> PatientDTO patientsEmailEmailGet(email)

Get a patient by email

Returns the patient with the specified email. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8085");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String email = "email_example"; // String | 
    try {
      PatientDTO result = apiInstance.patientsEmailEmailGet(email);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#patientsEmailEmailGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **email** | **String**|  |

### Return type

[**PatientDTO**](PatientDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The requested patient was returned successfully |  -  |
**404** | The patient with the specified email was not found |  -  |

<a name="patientsLoginPost"></a>
# **patientsLoginPost**
> patientsLoginPost(patient)

Log in a patient

Logs in a patient by verifying their email and password. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8085");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    PatientLoginDTO patient = new PatientLoginDTO(); // PatientLoginDTO | 
    try {
      apiInstance.patientsLoginPost(patient);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#patientsLoginPost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **patient** | **PatientLoginDTO**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The patient was logged in successfully |  -  |
**401** | The email and password combination is invalid |  -  |
**404** | The patient with the specified email was not found |  -  |

<a name="patientsPidGet"></a>
# **patientsPidGet**
> PatientLoginDTO patientsPidGet(pid)

Get a patient by ID

Returns the patient with the specified ID. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8085");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer pid = 56; // Integer | 
    try {
      PatientLoginDTO result = apiInstance.patientsPidGet(pid);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#patientsPidGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **pid** | **Integer**|  |

### Return type

[**PatientLoginDTO**](PatientLoginDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The requested patient was returned successfully |  -  |

<a name="patientsRegisterPost"></a>
# **patientsRegisterPost**
> patientsRegisterPost(patient)

Register a new patient

Registers a new patient in the system. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8085");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    PatientDTO patient = new PatientDTO(); // PatientDTO | 
    try {
      apiInstance.patientsRegisterPost(patient);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#patientsRegisterPost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **patient** | [**PatientDTO**](PatientDTO.md)|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The patient was registered successfully |  -  |
**409** | A patient with the same ID already exists |  -  |

<a name="reject"></a>
# **reject**
> reject(name, doctor, patient)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8085");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String name = "name_example"; // String | 
    Integer doctor = 56; // Integer | 
    Integer patient = 56; // Integer | 
    try {
      apiInstance.reject(name, doctor, patient);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#reject");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **String**|  |
 **doctor** | **Integer**|  |
 **patient** | **Integer**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Success |  -  |
**404** | Not Found |  -  |

<a name="requestsCreatePost"></a>
# **requestsCreatePost**
> requestsCreatePost(request)

Create a new request

Creates a new request in the system. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8085");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    RequestModel request = new RequestModel(); // RequestModel | 
    try {
      apiInstance.requestsCreatePost(request);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#requestsCreatePost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **request** | [**RequestModel**](RequestModel.md)|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The request was created successfully |  -  |
**409** | A request with the same session name already exists |  -  |

<a name="requestsIdGet"></a>
# **requestsIdGet**
> requestsIdGet(id)

Get request session by ID

Returns the request session with the specified ID.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8085");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer id = 56; // Integer | 
    try {
      apiInstance.requestsIdGet(id);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#requestsIdGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** |  |  -  |

<a name="requestsPendingDoctorIdGet"></a>
# **requestsPendingDoctorIdGet**
> requestsPendingDoctorIdGet(id)

Get pending request sessions objects by doctor ID

Returns the pending request sessions objects for the doctor with the specified ID.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8085");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer id = 56; // Integer | 
    try {
      apiInstance.requestsPendingDoctorIdGet(id);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#requestsPendingDoctorIdGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** |  |  -  |

<a name="requestsPendingPatientIdGet"></a>
# **requestsPendingPatientIdGet**
> requestsPendingPatientIdGet(id)

Get pending request sessions objects by patient ID

Returns the pending request sessions objects for the patient with the specified ID.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8085");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer id = 56; // Integer | 
    try {
      apiInstance.requestsPendingPatientIdGet(id);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#requestsPendingPatientIdGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** |  |  -  |

<a name="requestsRejectedDoctorIdGet"></a>
# **requestsRejectedDoctorIdGet**
> requestsRejectedDoctorIdGet(id)

Get rejected request sessions objects by doctor ID

Returns the rejected request sessions objects for the doctor with the specified ID.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8085");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer id = 56; // Integer | 
    try {
      apiInstance.requestsRejectedDoctorIdGet(id);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#requestsRejectedDoctorIdGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** |  |  -  |

<a name="requestsRejectedPatientIdGet"></a>
# **requestsRejectedPatientIdGet**
> requestsRejectedPatientIdGet(id)

Get rejected request sessions objects by doctor ID

Returns the rejected request sessions objects for the doctor with the specified ID.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8085");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer id = 56; // Integer | 
    try {
      apiInstance.requestsRejectedPatientIdGet(id);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#requestsRejectedPatientIdGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** |  |  -  |

<a name="update"></a>
# **update**
> update(doctor, name)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8085");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer doctor = 56; // Integer | 
    String name = "name_example"; // String | 
    try {
      apiInstance.update(doctor, name);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#update");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **doctor** | **Integer**|  |
 **name** | **String**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Success |  -  |
**404** | Not Found |  -  |
**409** | Conflict |  -  |

