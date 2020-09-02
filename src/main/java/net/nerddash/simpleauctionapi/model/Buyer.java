package net.nerddash.simpleauctionapi.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@SuppressWarnings("serial")
@Entity
@Table(name = "buyers")
public class Buyer implements ApiEntity, UserDetails {

	public Buyer() {
	}

	public Buyer(@NotNull @Size(min = 3, max = 100) String name, @NotNull String phoneNumber, String phoneNumberCrypt,
			String farmName, boolean enable) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.phoneNumberCrypt = phoneNumberCrypt;
		this.farmName = farmName;
		this.enable = enable;
		this.createdAt = new Date();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min = 3, max = 100)
	private String name;

	@NotNull
	private String phoneNumber;

	@NotNull
	private String phoneNumberCrypt;

	private String gtaFullName;
	private String gtaCpfCnpj;
	private String gtaAddress;
	private String gtaNeighborhood;
	private Long gtaZip;
	private String gtaCounty;
	private String gtaPhoneNumber;
	private String gtaStateInscrition;

	private String farmName;

	@CreationTimestamp
	private Date createdAt;

	@UpdateTimestamp
	private Date updatedAt;

	private boolean enable = true;

	@ManyToMany(fetch = FetchType.EAGER)
	private List<Profile> profiles = new ArrayList<Profile>(Arrays.asList(new Profile(Role.ROLE_BUYER)));

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Buyer other = (Buyer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String getPhoneNumberCrypt() {
		return phoneNumberCrypt;
	}

	public void setPhoneNumberCrypt(String phoneNumberCrypt) {
		this.phoneNumberCrypt = phoneNumberCrypt;
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

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return profiles;
	}

	@Override
	public String getPassword() {
		return this.getPhoneNumberCrypt();
	}

	@Override
	public String getUsername() {
		return this.getPhoneNumber();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

}