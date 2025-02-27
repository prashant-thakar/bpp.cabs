package in.succinct.bpp.cabs.db.model.demand;

import com.venky.geo.GeoLocation;
import com.venky.swf.db.annotations.column.IS_NULLABLE;
import com.venky.swf.db.annotations.column.IS_VIRTUAL;
import com.venky.swf.db.annotations.column.ui.PROTECTION;
import com.venky.swf.db.annotations.column.ui.PROTECTION.Kind;
import com.venky.swf.db.annotations.column.validations.Enumeration;
import com.venky.swf.db.annotations.column.validations.IntegerRange;
import com.venky.swf.db.annotations.model.MENU;
import com.venky.swf.db.model.Model;
import com.venky.swf.routing.Config;
import in.succinct.bpp.cabs.db.model.routes.Route;
import in.succinct.bpp.cabs.db.model.supply.DeploymentPurpose;
import in.succinct.bpp.cabs.db.model.supply.DriverLogin;
import in.succinct.bpp.cabs.db.model.supply.User;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@MENU("Trip")
public interface Trip extends Model, GeoLocation {
    public static  final String UnConfirmed = "Not Confirmed";
    public static  final String NotStarted = "Not Started";
    public static  final String Confirmed = NotStarted;
    public static  final String Started = "Started";
    public static  final String Ended = "Ended";

    public static  final String Canceled = "Canceled";


    @Enumeration(UnConfirmed +"," + Confirmed + "," + Started  + "," + Ended + "," + Canceled)
    public String getStatus();
    public void setStatus(String status);

    public Long getDeploymentPurposeId();
    public void setDeploymentPurposeId(Long id);
    public DeploymentPurpose getDeploymentPurpose();

    public Timestamp getScheduledStart();
    public void setScheduledStart(Timestamp requestedStart);

    public Timestamp getStartTs();
    public void setStartTs(Timestamp start);

    public Timestamp getEndTs();
    public void setEndTs(Timestamp end);

    public String getVehicleTags();
    public void setVehicleTags(String vehicleTags);

    public Long getPassengerId();
    public void setPassengerId(Long id);
    public User getPassenger();

    public Long getPayerId();
    public void setPayerId(Long id);
    public User getPayer();


    /* Route may be static or dynamic */
    public Long getRouteId();
    public void setRouteId(Long id);
    public Route getRoute();

    public Long getDriverLoginId();
    public void setDriverLoginId(Long id);
    public DriverLogin getDriverLogin();


    @IntegerRange(min = 1,max = 5)
    public Double getDriverRating();
    public void setDriverRating(Double driverRating);

    @IntegerRange(min = 1,max = 5)
    public Double getPassengerRating();
    public void setPassengerRating(Double passengerRating);

    @IntegerRange(min = 1,max = 5)
    public Double getVehicleRating();
    public void setVehicleRating(Double vehicleRating);


    @IS_VIRTUAL
    @PROTECTION(Kind.DISABLED)
    public BigDecimal getLat();

    @IS_VIRTUAL
    @PROTECTION(Kind.DISABLED)
    public BigDecimal getLng();

    public List<TripStop>  getTripStops();


    public void allocate();

    public Double getPrice();
    public void setPrice (Double price);

    public Double getIGst();
    public void setIGst(Double gst);

    public Double getCGst();
    public void setCGst(Double gst);

    public Double getSGst();
    public void setSGst(Double gst);

    //* This is what is paid by the client.
    public Double getSellingPrice();
    public void setSellingPrice(Double totalPrice);

    public void start();
    public void end();
}
