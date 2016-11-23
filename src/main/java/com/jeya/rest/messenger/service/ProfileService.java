package com.jeya.rest.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.jeya.rest.messenger.database.DatabaseClass;
import com.jeya.rest.messenger.model.Profile;

public class ProfileService {
	private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService()
	{
		profiles.put("ProfileName1", new Profile(1, "ProfileName1", "FirstName1", "LastName1"));
		profiles.put("ProfileName2", new Profile(2, "ProfileName2", "FirstName2", "LastName2"));
	}
	
	public List<Profile> getAllProfiles()
	{
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String profileName)
	{
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile)
	{
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile)
	{
		if(profile.getProfileName().isEmpty()){
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeProfile(String profileName)
	{
		return profiles.remove(profileName);
	}
}