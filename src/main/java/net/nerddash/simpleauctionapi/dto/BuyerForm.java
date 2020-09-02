package net.nerddash.simpleauctionapi.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import net.nerddash.simpleauctionapi.model.Buyer;

public class BuyerForm implements Form<Buyer> {

	@NotNull
	@NotEmpty
	protected String name;

	@NotNull
	@NotEmpty
	@Pattern(regexp = "(^(\\+55)?\\d{2}[8-9]?\\d{4}\\d{4})")
	protected String phoneNumber;

	@NotNull
	@NotEmpty
	protected String phoneNumberCrypt;

	@NotNull
	@NotEmpty
	protected String farmName;

	protected boolean enable = true;

	@Override
	public Buyer toEntity() {
		return new Buyer(name, phoneNumber, phoneNumberCrypt, farmName, enable);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getFarmName() {
		return farmName;
	}

	public void setFarmName(String farmName) {
		this.farmName = farmName;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	@Override
	public Buyer updateEntity(Buyer savedEntity) {

		if (savedEntity != null) {

			savedEntity.setPhoneNumber(phoneNumber);
			savedEntity.setPhoneNumberCrypt(phoneNumberCrypt);
			savedEntity.setName(name);
			savedEntity.setFarmName(farmName);
			savedEntity.setUpdatedAt(new Date());
		}

		return savedEntity;
	}

	public String getPhoneNumberCrypt() {
		return phoneNumberCrypt;
	}

	public void setPhoneNumberCrypt(String phoneNumberCrypt) {
		this.phoneNumberCrypt = phoneNumberCrypt;
	}

}
