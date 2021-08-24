package cn.tedu.aeurope.entity;

import java.io.Serializable;
	/**
	 * about-FAQ實體類
	 */
public class AboutFAQ implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer aboutFaqId;
	private String faqCode;
	private String aboutQuestion;
	private String aboutAnswer;
	private Integer faqPriority;
	public Integer getAboutFaqId() {
		return aboutFaqId;
	}
	public void setAboutFaqId(Integer aboutFaqId) {
		this.aboutFaqId = aboutFaqId;
	}
	public String getFaqCode() {
		return faqCode;
	}
	public void setFaqCode(String faqCode) {
		this.faqCode = faqCode;
	}
	public String getAboutQuestion() {
		return aboutQuestion;
	}
	public void setAboutQuestion(String aboutQuestion) {
		this.aboutQuestion = aboutQuestion;
	}
	public String getAboutAnswer() {
		return aboutAnswer;
	}
	public void setAboutAnswer(String aboutAnswer) {
		this.aboutAnswer = aboutAnswer;
	}
	public Integer getFaqPriority() {
		return faqPriority;
	}
	public void setFaqPriority(Integer faqPriority) {
		this.faqPriority = faqPriority;
	}
	@Override
	public String toString() {
		return "AboutFAQ [aboutFaqId=" + aboutFaqId + ", faqCode=" + faqCode + ", aboutQuestion=" + aboutQuestion
				+ ", aboutAnswer=" + aboutAnswer + ", faqPriority=" + faqPriority + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aboutFaqId == null) ? 0 : aboutFaqId.hashCode());
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
		AboutFAQ other = (AboutFAQ) obj;
		if (aboutFaqId == null) {
			if (other.aboutFaqId != null)
				return false;
		} else if (!aboutFaqId.equals(other.aboutFaqId))
			return false;
		return true;
	}

}
