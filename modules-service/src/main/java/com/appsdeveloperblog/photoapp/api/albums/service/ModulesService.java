/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appsdeveloperblog.photoapp.api.albums.service;


import com.appsdeveloperblog.photoapp.api.albums.data.ModuleEntity;
import java.util.List;

public interface ModulesService {
    List<ModuleEntity> getAlbums(String userId);
}
