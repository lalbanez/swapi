package swapi.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import swapi.model.People;
import swapi.model.Planet;
import swapi.model.Starship;
import swapi.model.Trafic;
import swapi.service.ClientWS;

@ManagedBean
@SessionScoped
public class CadastroController implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Trafic> mainList;

	private List<Starship> starships;

	private Starship selectedStarship;

	private Starship starshipChoised;

	private Planet planetChoised;

	private Planet planetSelected;

	private List<People> peopleChoised;

	private Trafic traficSelected;

	public boolean habilitaPlanets;

	public boolean habilitaPeople;

	private List<Planet> planets;

	private List<People> peoples = new ArrayList<People>();

	public CadastroController() {
		mainList = new ArrayList<Trafic>();
		setHabilitaPeople(false);
		setHabilitaPlanets(false);
	}

	public void carregarListaNaves() {
		ClientWS clientWS = new ClientWS();
		starships = new ArrayList<Starship>();
		starships.addAll(clientWS.getStarships());
	}

	public void carregarListaPlanetas() {
		ClientWS clientWS = new ClientWS();
		planets = new ArrayList<Planet>();
		planets.addAll(clientWS.getPlanets());
	}

	public void carregarListaPessoas() {
		ClientWS clientWS = new ClientWS();
		peoples = new ArrayList<People>();
		peoples.addAll(clientWS.getPeoples());
	}

	public String incluirVoo() {
		carregarListaNaves();
		setPlanets(new ArrayList<>());
		setPeoples(new ArrayList<>());
		setStarshipChoised(new Starship());
		setPlanetChoised(new Planet());
		setPeopleChoised(new ArrayList<>());

		return "incluirVoo";
	}

	public void carregaPlanet() {
		carregarListaPlanetas();
		setHabilitaPlanets(true);
	}

	public void excluirLinha(Trafic trafic) {
		System.out.println("Delete -> " + trafic);
		mainList.remove(trafic);
	}

	public void carregaPeople() {
		carregarListaPessoas();
		setHabilitaPeople(true);
	}

	public String submit() {
		System.out.println(getPeopleChoised());
		System.out.println(getPlanetChoised());
		System.out.println(getStarshipChoised());

		if (validaInclusao()) {
			mainList.add(new Trafic(getStarshipChoised(), getPlanetChoised(), getPeopleChoised()));
			return "index";
		}

		return "";

	}

	private boolean validaInclusao() {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Plano Adicionado com sucesso",
				"Mensagem do aviso flutuante Completa");

		if (getStarshipChoised() == null) {
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informe a nave desejada para continuar",
					"Mensagem do aviso flutuante Completa");
			context.addMessage("aviso", msg);
			return false;
		}
		if (getPlanetChoised() == null) {
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informe o destino desejado para continuar",
					"Mensagem do aviso flutuante Completa");
			context.addMessage("aviso", msg);
			return false;
		}
		if (getPeopleChoised() == null || getPeopleChoised().isEmpty()) {
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informe ao menos um tripulante para continuar",
					"Mensagem do aviso flutuante Completa");
			context.addMessage("aviso", msg);
			return false;
		}

		if (Integer.parseInt(getStarshipChoised().getPassengers()) < getPeopleChoised().size()) {
			int diferenca = getPeopleChoised().size() - Integer.parseInt(getStarshipChoised().getPassengers());
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"A nave escolhida comporta apenas " + getStarshipChoised().getPassengers()
							+ ". Escolha outra nave ou retire " + diferenca + " passageiro(s) ",
					"Mensagem do aviso flutuante Completa");
			context.addMessage("aviso", msg);
			return false;
		}

		if (getMainList().size() != 0 && getMainList().get(getMainList().size() - 1).getPlanet().getName()
				.equals(getPlanetChoised().getName())) {
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"O planeta destino não pode ser o mesmo que o voo anterior",
					"Mensagem do aviso flutuante Completa");
			context.addMessage("aviso", msg);
			return false;
		}

		context.addMessage("aviso", msg);
		return true;
	}

	public List<Trafic> getMainList() {
		return mainList;
	}

	public void setMainList(List<Trafic> mainList) {
		this.mainList = mainList;
	}

	public List<Starship> getStarships() {
		return starships;
	}

	public void setStarships(List<Starship> starships) {
		this.starships = starships;
	}

	public List<Planet> getPlanets() {
		return planets;
	}

	public void setPlanets(List<Planet> planets) {
		this.planets = planets;
	}

	public List<People> getPeoples() {
		return peoples;
	}

	public void setPeoples(List<People> peoples) {
		this.peoples = peoples;
	}

	public Starship getSelectedStarship() {
		return selectedStarship;
	}

	public void setSelectedStarship(Starship selectedStarship) {
		this.selectedStarship = selectedStarship;
	}

	public Starship getStarshipChoised() {
		return starshipChoised;
	}

	public void setStarshipChoised(Starship starshipChoised) {
		this.starshipChoised = starshipChoised;
	}

	public Planet getPlanetChoised() {
		return planetChoised;
	}

	public void setPlanetChoised(Planet planetChoised) {
		this.planetChoised = planetChoised;
	}

	public Planet getPlanetSelected() {
		return planetSelected;
	}

	public void setPlanetSelected(Planet planetSelected) {
		this.planetSelected = planetSelected;
	}

	public List<People> getPeopleChoised() {
		return peopleChoised;
	}

	public void setPeopleChoised(List<People> peopleChoised) {
		this.peopleChoised = peopleChoised;
	}

	public boolean isHabilitaPlanets() {
		return habilitaPlanets;
	}

	public void setHabilitaPlanets(boolean habilitaPlanets) {
		this.habilitaPlanets = habilitaPlanets;
	}

	public boolean isHabilitaPeople() {
		return habilitaPeople;
	}

	public void setHabilitaPeople(boolean habilitaPeople) {
		this.habilitaPeople = habilitaPeople;
	}

	public Trafic getTraficSelected() {
		return traficSelected;
	}

	public void setTraficSelected(Trafic traficSelected) {
		this.traficSelected = traficSelected;
	}

}
