package com.shohrab.notepadservice.controller;

import com.shohrab.notepadservice.dtos.NoteDto;
import com.shohrab.notepadservice.entities.Note;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/default")
public interface NoteController {

    @GetMapping("/all")
    public ResponseEntity<List<NoteDto>> getAllNotes();

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody NoteDto noteDto);

    @GetMapping("/find/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable("id") String id);

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody NoteDto noteDto, @PathVariable("id") String id);

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id);
}
