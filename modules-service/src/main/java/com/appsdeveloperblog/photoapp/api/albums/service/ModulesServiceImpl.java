/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appsdeveloperblog.photoapp.api.albums.service;

import com.appsdeveloperblog.photoapp.api.albums.data.ModuleEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ModulesServiceImpl implements ModulesService {

    @Override
    public List<ModuleEntity> getAlbums(String userId) {
        List<ModuleEntity> returnValue = new ArrayList<>();
        
        ModuleEntity moduleEntity = new ModuleEntity();
        moduleEntity.setUserId(userId);
        moduleEntity.setAlbumId("album1Id");
        moduleEntity.setDescription("album 1 description");
        moduleEntity.setId(1L);
        moduleEntity.setName("album 1 name");
        
        ModuleEntity moduleEntity2 = new ModuleEntity();
        moduleEntity2.setUserId(userId);
        moduleEntity2.setAlbumId("album2Id");
        moduleEntity2.setDescription("album 2 description");
        moduleEntity2.setId(2L);
        moduleEntity2.setName("album 2 name");
        
        returnValue.add(moduleEntity);
        returnValue.add(moduleEntity2);
        
        return returnValue;
    }
    
}
