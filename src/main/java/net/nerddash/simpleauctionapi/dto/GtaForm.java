package net.nerddash.simpleauctionapi.dto;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import com.sun.istack.NotNull;

import net.nerddash.simpleauctionapi.model.Buyer;

public class GtaForm implements Form<Buyer> {

	@NotNull
	private Long id;

	@NotNull
	private Long gtaZip;

	@NotNull
	@NotEmpty
	private String gtaFullName;

	@CNPJ
	@CPF
	@NotNull
	private String gtaCpfCnpj;

	@NotNull
	@NotEmpty
	private String gtaAddress;

	@NotNull
	@NotEmpty
	private String gtaNeighborhood;

	@NotNull
	@NotEmpty
	private String gtaCounty;

	private String gtaPhoneNumber;

	@NotNull
	@NotEmpty
	private String gtaStateInscrition;

	@Override
	public Buyer toEntity() {
		return null;
	}

	@Override
	public Buyer updateEntity(Buyer savedEntity) {

		if (savedEntity != null) {

			savedEntity.setGtaFullName(gtaFullName);
			savedEntity.setGtaAddress(gtaAddress);
			savedEntity.setGtaCounty(gtaCounty);
			savedEntity.setGtaCpfCnpj(gtaCpfCnpj);
			savedEntity.setGtaNeighborhood(gtaNeighborhood);
			savedEntity.setGtaPhoneNumber(gtaPhoneNumber);
			savedEntity.setGtaStateInscrition(gtaStateInscrition);
			savedEntity.setGtaZip(gtaZip);

		}

		return savedEntity;
	}

	public String getGtaFullName() {
		return gtaFullName;
	}

	public void setGtaFullName(String gtaFullName) {
		this.gtaFullName = gtaFullName;
	}

	public String getGtaCpfCnpj() {
		return gtaCpfCnpj;
	}

	public void setGtaCpfCnpj(String gtaCpfCnpj) {
		this.gtaCpfCnpj = gtaCpfCnpj;
	}

	public String getGtaAddress() {
		return gtaAddress;
	}

	public void setGtaAddress(String gtaAddress) {
		this.gtaAddress = gtaAddress;
	}

	public String getGtaNeighborhood() {
		return gtaNeighborhood;
	}

	public void setGtaNeighborhood(String gtaNeighborhood) {
		this.gtaNeighborhood = gtaNeighborhood;
	}

	public Long getGtaZip() {
		return gtaZip;
	}

	public void setGtaZip(Long gtaZip) {
		this.gtaZip = gtaZip;
	}

	public String getGtaCounty() {
		return gtaCounty;
	}

	public void setGtaCounty(String gtaCounty) {
		this.gtaCounty = gtaCounty;
	}

	public String getGtaPhoneNumber() {
		return gtaPhoneNumber;
	}

	public void setGtaPhoneNumber(String gtaPhoneNumber) {
		this.gtaPhoneNumber = gtaPhoneNumber;
	}

	public String getGtaStateInscrition() {
		return gtaStateInscrition;
	}

	public void setGtaStateInscrition(String gtaStateInscrition) {
		this.gtaStateInscrition = gtaStateInscrition;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
