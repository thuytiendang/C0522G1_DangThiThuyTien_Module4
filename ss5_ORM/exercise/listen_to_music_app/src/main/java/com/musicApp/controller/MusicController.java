package com.musicApp.controller;

import com.musicApp.model.Music;
import com.musicApp.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MusicController {

    @Autowired
    private IMusicService iMusicService;

    @GetMapping("/")
    public String showList(Model model) {
        List<Music> musicList = iMusicService.findAll();
        model.addAttribute("musicList", musicList);
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("music", new Music());
        return "create";
    }

    @PostMapping("/save")
    public String save(Music music, RedirectAttributes redirectAttributes) {
        iMusicService.save(music);
        redirectAttributes.addFlashAttribute("mess", "Add new music successfully!");
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("music", iMusicService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(Music music, RedirectAttributes redirectAttributes){
        iMusicService.update(music);
        redirectAttributes.addFlashAttribute("mess", "Update music successfully!");
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("music", iMusicService.findById(id));
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(Music music, RedirectAttributes redirectAttributes) {
        iMusicService.delete(music.getId());
        redirectAttributes.addFlashAttribute("mess", "Delete product successfully!");
        return "redirect:/";
    }

}
