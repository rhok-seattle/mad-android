package org.rhok;
/*
    * First Name : first_name:string
    * Middle Name : middle_name:string
    * Last Name : last_name:string
    * Street Address 1 : street1:string
    * Street Address 2 :  :string
    * City : city:string
    * County : county:string
    * Zip : postcode:string
    * Latitude : lat:float - 
    * Longitude : long:float
    * Occupant: Owner or Renter (are you an owner?) : owner:boolean
    * Estimated Pre-Disaster FMV of STRUCTURE : estpredistfmv:integer
    * Estimated STRUCTURE Loss in $$ : eststructloss:integer
    * Estimated PERSONAL PROPERTY Loss in $$ : estperproploss:integer
    * Primary Cause of Damage : cause:foreign key
    * Type of Insurance : insurance:foreign key
    * Deductible : deductible:integer
    * Habitable? Yes or No : habitable:boolean
    * Accessible? Yes or No : accessible:boolean
    * Category of Damage : damage:foreign key (structural, roadway, land)
    * Description of Damages : description:text
    * Contact Name : contact:string
    * Contact Phone : phone:string
    * Contact Email : email:string
    * Total Uninsured Loss : uninsured_loss:integer
    * % of Total Uninsured Loss / FMV : (calculated)
    * Picture, if available : string (url of upload site) 
 * 
 */

public class Entry {
	public enum Occupant{
		OWNER,
		RENTER,
	};
	private String firstName;
	private String middleName;
	private String address1;
	private String address2;
	private String city;
	private String zip;
	private Occupant occupant;
}
