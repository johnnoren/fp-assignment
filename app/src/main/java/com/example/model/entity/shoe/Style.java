package com.example.model.entity.shoe;

import java.util.List;
import java.util.UUID;

public record Style(UUID uuid, StyleName styleName, ProductImage productImage, Model model, Brand brand,
					List<Colour> colours) {

}
