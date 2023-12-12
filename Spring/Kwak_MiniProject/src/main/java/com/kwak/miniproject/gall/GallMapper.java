package com.kwak.miniproject.gall;

import java.util.List;

public interface GallMapper {
	public abstract List<Gall> getPhoto(Gall g);
	public abstract int upload(Gall g);
	public abstract int delete(Gall g);
}
