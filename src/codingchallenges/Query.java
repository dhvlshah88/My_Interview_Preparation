package codingchallenges;

public class Query {
	
	private String name;
	private String url;
	private Integer rank;
	private String score;
	
	/**
	 * @return the name
	 */
	public String getName()
	{
		return this.name;
	}

	/**
	 * @param name the query name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the rank
	 */
	public Integer getRank() {
		return rank;
	}

	/**
	 * @param rank the rank to set
	 */
	public void setRank(Integer rank) {
		this.rank = rank;
	}

	/**
	 * @return the score
	 */
	public String getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(String score) {
		this.score = score;
	}

}
