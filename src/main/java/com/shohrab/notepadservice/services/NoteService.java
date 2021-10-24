package com.shohrab.notepadservice.services;

import com.shohrab.notepadservice.dtos.NoteDto;
import com.shohrab.notepadservice.entities.Note;
import com.shohrab.notepadservice.exceptions.NoteNotFoundException;
import com.shohrab.notepadservice.mappers.NoteMapper;
import com.shohrab.notepadservice.repositories.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NoteService {

    @Autowired
    private final NoteRepository noteRepository;

    @Autowired
    private final NoteMapper noteMapper;

    public List<NoteDto> allNotes() {

        return noteMapper.noteToNoteDtos(noteRepository.findAll());
    }

    @Transactional
    public void save(NoteDto noteDto) {

        this.noteRepository.save(noteMapper.noteDtoToNote(noteDto));
    }

    public void updateNote(NoteDto noteDto, String id){
        var note = findNote(id);
        note.setBody(noteDto.getBody());
        this.noteRepository.save(note);
    }

    public Note findNote(String id){
        return noteRepository.findNoteById(id)
                .orElseThrow(() -> new NoteNotFoundException("Note by id" + id + "was not found."));
    }

    public void deleteNote(String id){
        noteRepository.deleteNoteById(id);
    }


}