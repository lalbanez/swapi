package swapi.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import swapi.model.People;
import swapi.model.Planet;
import swapi.model.Root;
import swapi.model.Starship;

public class ClientWS {

	protected String getWebService(String urlRecived) {
		try {
			URL url = new URL(urlRecived);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String retorno = "";
			String output;
			while ((output = br.readLine()) != null) {
				retorno += output;
			}
			conn.disconnect();

			return retorno;
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}

	public List<Starship> getStarships() {
		Gson gson = new Gson();

		Root<Starship> root;
		List<Starship> list = new ArrayList<>();

		int page = 1;

		do {
			root = gson.fromJson(getWebService("http://swapi.co/api/starships/?page=" + page),
					new TypeToken<Root<Starship>>() {}.getType());
			list.addAll(root.getResults());
			page++;
		} while (root.hasMore());

		return list;

	}

	public List<People> getPeoples() {
		Gson gson = new Gson();

		Root<People> root;
		List<People> list = new ArrayList<>();

		int page = 1;

		do {
			root = gson.fromJson(getWebService("http://swapi.co/api/people/?page=" + page),
					new TypeToken<Root<People>>() {}.getType());
			list.addAll(root.getResults());
			page++;
		} while (root.hasMore());

		return list;

	}

	public List<Planet> getPlanets() {
		Gson gson = new Gson();

		Root<Planet> root;
		List<Planet> list = new ArrayList<>();

		int page = 1;

		do {
			root = gson.fromJson(getWebService("http://swapi.co/api/planets/?page=" + page),
					new TypeToken<Root<Planet>>() {}.getType());
			list.addAll(root.getResults());
			page++;
		} while (root.hasMore());

		return list;

	}

	public static void main(String[] args) {
		ClientWS ws = new ClientWS();

		ws.getPlanets();
	}
}