package com.shohrab.notepadservice.mappers;

import com.shohrab.notepadservice.dtos.NoteDto;
import com.shohrab.notepadservice.entities.Note;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface NoteMapper {
    NoteDto noteToNoteDto(Note note);
    Note noteDtoToNote(NoteDto noteDto);

    List<Note> noteDtoToNotes(List<NoteDto> noteDtos);

    List<NoteDto> noteToNoteDtos(List<Note> notes);
}
