export type ArtWorkList = {
  pagination: {
    total: number,
    current: number
  },
  data: ArtWorkData []
}

export type ArtWork = {
  data: ArtWorkData
}

export type ArtWorkData = {
      id: number,
      title: string,
      date_end: number,
      image: string | undefined,
      description: string | undefined,
      short_description: string | undefined,
      provenance_text: string | undefined,
}
