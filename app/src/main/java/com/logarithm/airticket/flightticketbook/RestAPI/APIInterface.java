package com.logarithm.airticket.flightticketbook.RestAPI;



import com.logarithm.airticket.flightticketbook.ModelClass.BookTicket.BookTicket;
import com.logarithm.airticket.flightticketbook.ModelClass.DeleteFlight.DeleteFlight;
import com.logarithm.airticket.flightticketbook.ModelClass.Login;
import com.logarithm.airticket.flightticketbook.ModelClass.Profile.Profile;
import com.logarithm.airticket.flightticketbook.ModelClass.RecyclerGet;
import com.logarithm.airticket.flightticketbook.ModelClass.RecyclerMessage;
import com.logarithm.airticket.flightticketbook.ModelClass.Response;
import com.logarithm.airticket.flightticketbook.ModelClass.ViewBooking.ViewBooking;
import com.logarithm.airticket.flightticketbook.ParametersClass.AddAirport;
import com.logarithm.airticket.flightticketbook.ParametersClass.AddFlight;
import com.logarithm.airticket.flightticketbook.ParametersClass.Credentials;
import com.logarithm.airticket.flightticketbook.ParametersClass.DeleteAirport;
import com.logarithm.airticket.flightticketbook.ParametersClass.GetSpecFlight;
import com.logarithm.airticket.flightticketbook.ParametersClass.Register;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface APIInterface {

    @POST("auth/login/user")
    Call<Login> login(@Body Credentials credentials);

    @POST("auth/login/admin")
    Call<Login> loginAdmin(@Body Credentials credentials);

    @POST("auth/register/user")
    Call<com.logarithm.airticket.flightticketbook.ModelClass.Register.Register> register(@Body Register credentials);

    @POST("auth/register/admin")
    Call<com.logarithm.airticket.flightticketbook.ModelClass.Register.Register> registerAdmin(@Body Register credentials);

    @POST("flight/addflight")
    Call<Response> addFlight(@Header("Authorization") String token ,@Body AddFlight credentials);

    @POST("flight/addairport")
    Call<Response> addAirport(@Header("Authorization") String token ,@Body AddAirport name);

    @GET("flight/getallflights")
    Call<DeleteFlight> getAllflights(@Header("Authorization") String token);


    @POST("flight/getallspecflights")
    Call<RecyclerGet> getAllSpecflights(@Header("Authorization") String token, @Body  GetSpecFlight getSpecFlight);


    @HTTP(method = "DELETE", path = "flight/deleteflight", hasBody = true)
    Call<Response> deleteFlight(@Header("Authorization") String token, @Body com.logarithm.airticket.flightticketbook.ParametersClass.DeleteFlight deleteFlight);


    @HTTP(method = "DELETE", path = "flight/deleteairport", hasBody = true)
    Call<Response> deleteAirport(@Header("Authorization") String token, @Body DeleteAirport deleteFlight);

    @GET("flight/getallairports")
    Call<com.logarithm.airticket.flightticketbook.ModelClass.DeleteAirport.DeleteAirport> getAllAirports(@Header("Authorization") String token);

    @GET("auth/profile")
    Call<Profile> getProfile(@Header("Authorization") String token);


    @POST("booking/bookticket")
    Call<BookTicket> bookTicket(@Header("Authorization") String token,@Body com.logarithm.airticket.flightticketbook.ParametersClass.BookTicket bookTicket);

    @GET("booking/viewbookings")
    Call<ViewBooking> viewBookings(@Header("Authorization") String token);

    @GET("booking/viewallbookings")
    Call<ViewBooking> viewAllBookings(@Header("Authorization") String token);



























//
//    @GET("user/profile/get")
//    Call<DeviceInfo> getDeviceDetails(@Header("Authorization") String token);
//
//    @POST("apps/fingerprint-scanner/companies")
//    Call<Register> registerDevice(@Body com.famoco.morphodemo.ParametersClass.Register register, @Header("Authorization") String token);
//
//    @HTTP(method = "DELETE", path = "apps/fingerprint-scanner/companies/famoco", hasBody = true)
//    Call<Register> deregisterDevice(@Body Deregister deregister, @Header("Authorization") String token);
//
////    @GET("apps/fingerprint-scanner/companies/famoco")
////    Call<ResponseBody> getDeviceReg(@Header("Authorization") String token);
//
//    @POST("apps/fingerprint-scanner/permissions")
//    Call<com.famoco.morphodemo.Models.PermissionFP .Permission> getPermission(@Header("Authorization") String token, @Body Permission permission);
//
//    @POST
//    Call<RegisterFP> registerFP(@Header("Authorization") String token, @Body com.famoco.morphodemo.ParametersClass.RegisterFP permission, @Url String url);
//
//    @GET
//    Call<VerifyFP> verifyFP(@Header("Authorization") String token, @Url String url, @Query("uniqueDeviceId") String uniqueDeviceId);
//
//    @POST("apps/airport-security/fetch/permission")
//    Call<com.famoco.morphodemo.Models.Airport.Permission> getAirportPermission(@Body AirportPermission requesteePublicKey, @Header("Authorization") String token);
//
//
//    @POST("apps/airport-security/verify/passport")
//    Call<com.famoco.morphodemo.Models.Airport.Permission> verifyPassport(@Body PassportPermission passportPermission, @Header("Authorization") String token);
//
//    @GET("apps/airport-security/fetch/passport")
//    Call<FetchPassport> fetchPassport(@Header("Authorization") String token, @Query("requesteePublicKey") String requesteePublicKey);
//
//
//
//
//    @GET("apps/airport-security/fetch/trips")
//    Call<FetchTrips> fetchTrips(@Header("Authorization") String token, @Query("requesteePublicKey") String requesteePublicKey);
//
//    //Not used - Deprecated
//    @GET
//    Call<FetchIndividualTrip> fetchIndividualTrip(@Header("Authorization") String token, @Url String url, @Query("requesteePublicKey") String requesteePublicKey);

}