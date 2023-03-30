package DiamonShop.Entity;

public class Slides {
	private int id;
	private String img;
	private String content;
	private String caption;
	
	public Slides() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Slides(int id, String img, String content, String caption) {
		super();
		this.id = id;
		this.img = img;
		this.content = content;
		this.caption = caption;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}
	
	
}
